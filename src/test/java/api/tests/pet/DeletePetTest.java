package api.tests.pet;

import api.assertions.PetAssertions;
import api.config.ApiConfig;
import api.endpoints.PetEndpoint;
import api.models.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeletePetTest extends ApiConfig {

    private final PetEndpoint petEndpoint = new PetEndpoint();
    private Long testPetId;

    @BeforeEach
    public void setupTestData() {
        Pet testPet = Pet.builder()
                .id(66543L)
                .name("DeleteTestPet")
                .status("available")
                .category(4L, "Fish")
                .photoUrl("https://example.com/fish.jpg")
                .build();

        Response createResponse = petEndpoint.addPet(testPet);
        assertThat(createResponse.getStatusCode()).isEqualTo(200);

        testPetId = testPet.getId();
    }

    @Test
    @DisplayName("Should delete a pet")
    public void testDeletePet() {
        Response response = petEndpoint.deletePet(testPetId);

        PetAssertions.assertPetDeleted(response, testPetId);

        Response getResponse = petEndpoint.getPetById(testPetId);
        assertThat(getResponse.getStatusCode()).isEqualTo(404);
    }

}
