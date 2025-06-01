package api.tests.pet;

import api.config.ApiConfig;
import api.endpoints.PetEndpoint;
import api.models.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindPetsByStatusTest extends ApiConfig {

    private final PetEndpoint petEndpoint = new PetEndpoint();

    @Test
    @DisplayName("Should find pets by available status")
    public void testFindPetsByAvailableStatus() {
        Response response = petEndpoint.findPetsByStatus("available");

        assertThat(response.getStatusCode()).isEqualTo(200);

        List<Pet> pets = response.jsonPath().getList("", Pet.class);
        assertThat(pets).isNotEmpty();

        for (Pet pet : pets) {
            assertThat(pet.getStatus()).isEqualTo("available");
        }
    }

    @Test
    @DisplayName("Should find pets by pending status")
    public void testFindPetsByPendingStatus() {
        Response response = petEndpoint.findPetsByStatus("pending");

        assertThat(response.getStatusCode()).isEqualTo(200);

        List<Pet> pets = response.jsonPath().getList("", Pet.class);

        for (Pet pet : pets) {
            assertThat(pet.getStatus()).isEqualTo("pending");
        }
    }

    @Test
    @DisplayName("Should find pets by sold status")
    public void testFindPetsBySoldStatus() {
        Response response = petEndpoint.findPetsByStatus("sold");

        assertThat(response.getStatusCode()).isEqualTo(200);

        List<Pet> pets = response.jsonPath().getList("", Pet.class);

        for (Pet pet : pets) {
            assertThat(pet.getStatus()).isEqualTo("sold");
        }
    }
}
