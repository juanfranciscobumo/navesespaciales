package co.com.sofka.navesespaciales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NavesespacialesApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        //prueba unitaria del servicio getnave
        this.mockMvc.perform(get("/nave/get")).andDo(print()).andExpect(status().isOk());
        //prueba unitaria del servicio agregar nave
        this.mockMvc.perform(post("/nave/add?combustible=aceite&empuje=320&capacidadTransporte=3&nombre=Mercury"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("El tipo de nave es Naves tripuladas")));
        //prueba unitaria del servicio gettipos
        this.mockMvc.perform(get("/tipos/get")).andDo(print()).andExpect(status().isOk());
    }
}
