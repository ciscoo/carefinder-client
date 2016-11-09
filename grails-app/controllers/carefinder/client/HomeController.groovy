package carefinder.client

class HomeController {

    def apiService

    def index() {
        [hospitals: apiService.getHospitalsByState("Kentucky")]
    }
}
