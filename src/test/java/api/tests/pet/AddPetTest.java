package api.tests.pet;

import api.assertions.PetAssertions;
import api.config.ApiConfig;
import api.endpoints.PetEndpoint;
import api.models.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddPetTest extends ApiConfig {

    private final PetEndpoint petEndpoint = new PetEndpoint();

    @Test
    @DisplayName("Should add a new pet to the store")
    public void testAddNewPet() {
        // Arrange - Create test data
        Pet newPet = Pet.builder()
                .id(12345L)
                .name("Fluffy")
                .status("available")
                .category(1L, "Dogs")
                .photoUrl("https://example.com/dog.jpg")
                .tag(1L, "cute")
                .build();

        Response response = petEndpoint.addPet(newPet);

        PetAssertions.assertPetCreated(response, newPet);
    }

    @Test
    @DisplayName("Should add a pet with minimal required fields")
    public void testAddPetWithMinimalFields() {
        Pet minimalPet = Pet.builder()
                .id(12346L)
                .name("Rex")
                .photoUrl("https://example.com/rex.jpg")
                .build();

        Response response = petEndpoint.addPet(minimalPet);

        PetAssertions.assertPetCreated(response, minimalPet);
    }
}
