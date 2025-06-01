package api.assertions;

import api.models.Pet;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class PetAssertions {


    public static void assertPetCreated(Response response, Pet expectedPet) {
        assertThat(response.getStatusCode()).isEqualTo(200);

        Pet actualPet = response.as(Pet.class);
        assertThat(actualPet.getId()).isEqualTo(expectedPet.getId());
        assertThat(actualPet.getName()).isEqualTo(expectedPet.getName());
        assertThat(actualPet.getStatus()).isEqualTo(expectedPet.getStatus());

        if (expectedPet.getCategory() != null) {
            assertThat(actualPet.getCategory().getName()).isEqualTo(expectedPet.getCategory().getName());
        }
    }

    public static void assertPetRetrieved(Response response, Long expectedId) {
        assertThat(response.getStatusCode()).isEqualTo(200);

        Pet actualPet = response.as(Pet.class);
        assertThat(actualPet.getId()).isEqualTo(expectedId);
        assertThat(actualPet.getName()).isNotBlank();
    }

    public static void assertPetDeleted(Response response, Long petId) {
        assertThat(response.getStatusCode()).isEqualTo(200);
    }
}
