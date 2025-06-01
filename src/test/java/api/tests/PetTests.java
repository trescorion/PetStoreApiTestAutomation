package api.tests;

import api.config.ApiConfig;
import api.endpoints.PetEndpoint;
import api.models.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PetTests extends ApiConfig {

    private final PetEndpoint petEndpoint = new PetEndpoint();

    @Test
    public void testAddNewPet() {

        Pet pet = Pet.builder()
                .id(1234L)
                .name("Fluffy")
                .status("available")
                .category(1L, "Dogs")
                .photoUrl("https://example.com/dog.jpg")
                .tag(1L, "cute")
                .build();

        // Send POST request to add a new pet
        Response response = petEndpoint.addPet(pet);

        // Validate response
        assertThat(response.getStatusCode()).isEqualTo(200);

        // Validate response body
        Pet responsePet = response.as(Pet.class);
        assertThat(responsePet.getId()).isEqualTo(pet.getId());
        assertThat(responsePet.getName()).isEqualTo(pet.getName());
        assertThat(responsePet.getStatus()).isEqualTo(pet.getStatus());
    }


}
