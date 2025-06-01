package api.endpoints;

import api.models.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetEndpoint {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    /**
     * Adds a new pet to the store
     * @param pet the pet to add
     * @return the response
     */
    public Response addPet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
                .when()
                .post(BASE_URL + "/pet");
    }

    /**
     * Updates an existing pet
     * @param pet the pet to update
     * @return the response
     */
    public Response updatePet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
                .when()
                .put(BASE_URL + "/pet");
    }

    /**
     * Finds pets by status
     * @param status the status to find by (available, pending, sold)
     * @return the response
     */
    public Response findPetsByStatus(String status) {
        return given()
                .accept(ContentType.JSON)
                .queryParam("status", status)
                .when()
                .get(BASE_URL + "/pet/findByStatus");
    }

    /**
     * Gets a pet by ID
     * @param petId the ID of the pet to get
     * @return the response
     */
    public Response getPetById(Long petId) {
        return given()
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .when()
                .get(BASE_URL + "/pet/{petId}");
    }

    /**
     * Updates a pet with form data
     * @param petId the ID of the pet to update
     * @param name the new name
     * @param status the new status
     * @return the response
     */
    public Response updatePetWithForm(Long petId, String name, String status) {
        return given()
                .contentType(ContentType.URLENC)
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .formParam("name", name)
                .formParam("status", status)
                .when()
                .post(BASE_URL + "/pet/{petId}");
    }

    /**
     * Deletes a pet
     * @param petId the ID of the pet to delete
     * @return the response
     */
    public Response deletePet(Long petId) {
        return given()
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .when()
                .delete(BASE_URL + "/pet/{petId}");
    }

    /**
     * Uploads an image for a pet
     * @param petId the ID of the pet
     * @param additionalMetadata additional data to pass to the server
     * @param filePath the path to the file to upload
     * @return the response
     */
    public Response uploadImage(Long petId, String additionalMetadata, String filePath) {
        return given()
                .multiPart("additionalMetadata", additionalMetadata)
                .multiPart("file", filePath)
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .when()
                .post(BASE_URL + "/pet/{petId}/uploadImage");
    }
}
