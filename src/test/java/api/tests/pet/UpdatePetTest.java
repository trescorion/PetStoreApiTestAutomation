package api.tests.pet;

import api.config.ApiConfig;
import api.endpoints.PetEndpoint;
import api.models.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdatePetTest extends ApiConfig {

    private final PetEndpoint petEndpoint = new PetEndpoint();
    private Pet testPet;

    @BeforeEach
    public void setupTestData() {
        testPet = Pet.builder()
                .id(55432L)
                .name("UpdateTestPet")
                .status("available")
                .category(3L, "Birds")
                .photoUrl("https://example.com/bird.jpg")
                .build();

        Response createResponse = petEndpoint.addPet(testPet);
        assertThat(createResponse.getStatusCode()).isEqualTo(200);
    }

    @Test
    @DisplayName("Should update an existing pet")
    public void testUpdatePet() {
        testPet.setName("UpdatedPetName");
        testPet.setStatus("sold");

        Response response = petEndpoint.updatePet(testPet);

        assertThat(response.getStatusCode()).isEqualTo(200);

        Pet updatedPet = response.as(Pet.class);
        assertThat(updatedPet.getId()).isEqualTo(testPet.getId());
        assertThat(updatedPet.getName()).isEqualTo("UpdatedPetName");
        assertThat(updatedPet.getStatus()).isEqualTo("sold");
    }

    @Test
    @DisplayName("Should update a pet with form data")
    public void testUpdatePetWithForm() {
        String newName = "FormUpdatedPet";
        String newStatus = "pending";

        Response response = petEndpoint.updatePetWithForm(testPet.getId(), newName, newStatus);

        assertThat(response.getStatusCode()).isEqualTo(200);

        Response getResponse = petEndpoint.getPetById(testPet.getId());
        Pet updatedPet = getResponse.as(Pet.class);

        assertThat(updatedPet.getName()).isEqualTo(newName);
        assertThat(updatedPet.getStatus()).isEqualTo(newStatus);
    }
}
