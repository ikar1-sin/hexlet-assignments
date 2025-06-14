package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.junit.jupiter.Container;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
@AutoConfigureMockMvc
// BEGIN
@Testcontainers
@Transactional
// END
public class AppTest {

    @Autowired
    private MockMvc mockMvc;

    // BEGIN
    @Container
    private static PostgreSQLContainer<?> database = new PostgreSQLContainer<>("postgres")
        .withDatabaseName("postgres-db")
        .withUsername("admin")
        .withPassword("admin")
        .withInitScript("init.sql");
    // END

    @DynamicPropertySource
    private static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", database::getJdbcUrl);
        registry.add("spring.datasource.username", database::getUsername);
        registry.add("spring.datasource.password", database::getPassword);
    }

    @Test
    void testCreatePerson() throws Exception {
        MockHttpServletResponse responsePost = mockMvc
            .perform(
                post("/people")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"firstName\": \"Jackson\", \"lastName\": \"Bind\"}")
            )
            .andReturn()
            .getResponse();

        assertThat(responsePost.getStatus()).isEqualTo(200);

        MockHttpServletResponse response = mockMvc
            .perform(get("/people"))
            .andReturn()
            .getResponse();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON.toString());
        assertThat(response.getContentAsString()).contains("Jackson", "Bind");
    }

    @Test
    void testIndexPerson() throws Exception {
        var result = mockMvc.perform(
            get("/people")
        ).andExpect(status().isOk())
            .andReturn();

        var body = result.getResponse();
        assertThat(body.getContentAsString()).isNotNull();
    }

    @Test
    void testShowPerson() throws Exception {
        var result = mockMvc.perform(get("/people/{id}", 1L))
            .andExpect(status().isOk())
            .andReturn();

        assertThat(result.getResponse().getContentAsString()).contains("John", "Smith");
    }

    @Test
    void testPutPerson() throws Exception {

       var result = mockMvc.perform(patch("/people/{id}", 2L)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"lastName\": \"Down\"}"));

       var response = mockMvc.perform(get("/people"))
               .andReturn();

       assertThat(response.getResponse().getContentAsString()).contains("Down");
    }

    @Test
    void testDeletePerson() throws Exception {
        mockMvc.perform(delete("/people/{id}", 3L));
        var response = mockMvc.perform(get("/people/{id}", 3L)).andReturn();
        assertThat(response.getResponse().getContentAsString()).isEqualTo("");
    }
}
