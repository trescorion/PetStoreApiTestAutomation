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

public class GetPetTest extends ApiConfig {

    private final PetEndpoint petEndpoint = new PetEndpoint();
    private Long testPetId;

    @BeforeEach
    public void setupTestData() {
        Pet testPet = Pet.builder()
                .id(44321L)
                .name("TestPet")
                .status("available")
                .category(2L, "Cats")
                .photoUrl("https://example.com/cat.jpg")
                .build();

        Response createResponse = petEndpoint.addPet(testPet);
        assertThat(createResponse.getStatusCode()).isEqualTo(200);

        testPetId = testPet.getId();
    }

    @Test
    @DisplayName("Should retrieve pet by ID")
    public void testGetPetById() {
        Response response = petEndpoint.getPetById(testPetId);

        PetAssertions.assertPetRetrieved(response, testPetId);
    }

    @Test
    @DisplayName("Should return 404 for non-existent pet")
    public void testGetNonExistentPet() {
        Response response = petEndpoint.getPetById(99999999L);

        assertThat(response.getStatusCode()).isEqualTo(404);
    }
}
