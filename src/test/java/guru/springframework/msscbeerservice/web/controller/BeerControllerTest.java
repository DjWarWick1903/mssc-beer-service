package guru.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbeerservice.bootstrap.BeerLoader;
import guru.sfg.brewery.model.BeerDto;
import guru.sfg.brewery.model.BeerStyleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

@WebMvcTest(BeerController.class)
@ComponentScan(basePackages = "guru.springframework.msscbeerservice.web.mappers")
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    /*@Test
    void getBeerById() throws Exception{
        mockMvc.perform(get("/api/v1/beer/{beerId}", UUID.randomUUID().toString())
                        .param("iscold", "yes")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/beer-get", pathParameters(
                        parameterWithName("beerId").description("UUID of desired beer to get.")
                ), requestParameters(
                        parameterWithName("iscold").description("Is Beer Cold Query param")
                ), responseFields(
                        fieldWithPath("id").description("Id of Beer"),
                        fieldWithPath("version").description("Version number"),
                        fieldWithPath("createdDate").description("Date Created"),
                        fieldWithPath("lastModifiedDate").description("Date Updated"),
                        fieldWithPath("beerName").description("Beer Name"),
                        fieldWithPath("beerStyle").description("Beer Style"),
                        fieldWithPath("upc").description("UPC Of Beer"),
                        fieldWithPath("price").description("Price"),
                        fieldWithPath("quantityOnHand").description("Quantity On Hand")
                )));
    }

    @Test
    void saveNewBeer() throws Exception{
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        ConstrainedFields fields = new ConstrainedFields(BeerDto.class);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated())
                .andDo(document("v1/beer-new",
                        requestFields(
                                fields.withPath("id").ignored(),
                                fields.withPath("version").ignored(),
                                fields.withPath("createdDate").ignored(),
                                fields.withPath("lastModifiedDate").ignored(),
                                fields.withPath("beerName").description("Name of the beer"),
                                fields.withPath("beerStyle").description("Style of Beer"),
                                fields.withPath("upc").description("Beer UPC").attributes(),
                                fields.withPath("price").description("Beer Price"),
                                fields.withPath("quantityOnHand").ignored()
                        )));
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }*/

    BeerDto getValidBeerDto() {
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(BeerLoader.BEER_1_UPC)
                .build();
    }
}