package unii.entertainment.movie.movieapp.core.service.interceptor

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody


class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var uri = request.url

        val responseString =
            if (uri.toString().contains("https://api.themoviedb.org/3/movie/top_rated?page=1")) {
                retrieveFilmList()
            } else retrieveFilmDetail()

        return Response.Builder()
            .code(200)
            .message("")
            .request(chain.request())
            .protocol(Protocol.HTTP_2)
            .body(
                responseString.toResponseBody("application/json".toMediaTypeOrNull())
            )
            .addHeader("content-type", "application/json")
            .build()
    }


    private fun retrieveFilmList() =
        "{\"page\":1,\"results\":[{\"adult\":false,\"backdrop_path\":\"/gNBCvtYyGPbjPCT1k3MvJuNuXR6.jpg\",\"genre_ids\":[35,18,10749],\"id\":19404,\"original_language\":\"hi\",\"original_title\":\"दिलवाले दुल्हनिया ले जायेंगे\",\"overview\":\"Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.\",\"popularity\":23.774,\"poster_path\":\"/2CAL2433ZeIihfX1Hb2139CX0pW.jpg\",\"release_date\":\"1995-10-20\",\"title\":\"Dilwale Dulhania Le Jayenge\",\"video\":false,\"vote_average\":8.7,\"vote_count\":2885},{\"adult\":false,\"backdrop_path\":\"/jtAI6OJIWLWiRItNSZoWjrsUtmi.jpg\",\"genre_ids\":[10749],\"id\":724089,\"original_language\":\"en\",\"original_title\":\"Gabriel's Inferno Part II\",\"overview\":\"Professor Gabriel Emerson finally learns the truth about Julia Mitchell's identity, but his realization comes a moment too late. Julia is done waiting for the well-respected Dante specialist to remember her and wants nothing more to do with him. Can Gabriel win back her heart before she finds love in another's arms?\",\"popularity\":6.567,\"poster_path\":\"/x5o8cLZfEXMoZczTYWLrUo1P7UJ.jpg\",\"release_date\":\"2020-07-31\",\"title\":\"Gabriel's Inferno Part II\",\"video\":false,\"vote_average\":8.7,\"vote_count\":1255},{\"adult\":false,\"backdrop_path\":\"/iNh3BivHyg5sQRPP1KOkzguEX0H.jpg\",\"genre_ids\":[18,80],\"id\":278,\"original_language\":\"en\",\"original_title\":\"The Shawshank Redemption\",\"overview\":\"Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.\",\"popularity\":42.776,\"poster_path\":\"/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg\",\"release_date\":\"1994-09-23\",\"title\":\"The Shawshank Redemption\",\"video\":false,\"vote_average\":8.7,\"vote_count\":18938},{\"adult\":false,\"backdrop_path\":\"/rSPw7tgCH9c6NqICZef4kZjFOQ5.jpg\",\"genre_ids\":[18,80],\"id\":238,\"original_language\":\"en\",\"original_title\":\"The Godfather\",\"overview\":\"Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.\",\"popularity\":35.921,\"poster_path\":\"/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"release_date\":\"1972-03-14\",\"title\":\"The Godfather\",\"video\":false,\"vote_average\":8.7,\"vote_count\":14295}]}"

    private fun retrieveFilmDetail() = "{\"adult\":false,\"backdrop_path\":\"/gNBCvtYyGPbjPCT1k3MvJuNuXR6.jpg\",\"belongs_to_collection\":null,\"budget\":13200000,\"genres\":[{\"id\":35,\"name\":\"Comedy\"},{\"id\":18,\"name\":\"Drama\"},{\"id\":10749,\"name\":\"Romance\"}],\"homepage\":\"\",\"id\":19404,\"imdb_id\":\"tt0112870\",\"original_language\":\"hi\",\"original_title\":\"दिलवाले दुल्हनिया ले जायेंगे\",\"overview\":\"Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.\",\"popularity\":23.774,\"poster_path\":\"/2CAL2433ZeIihfX1Hb2139CX0pW.jpg\",\"production_companies\":[{\"id\":1569,\"logo_path\":\"/lvzN86o3jrP44DIvn4SMBLOl9PF.png\",\"name\":\"Yash Raj Films\",\"origin_country\":\"IN\"}],\"production_countries\":[{\"iso_3166_1\":\"IN\",\"name\":\"India\"}],\"release_date\":\"1995-10-20\",\"revenue\":100000000,\"runtime\":190,\"spoken_languages\":[{\"english_name\":\"Hindi\",\"iso_639_1\":\"hi\",\"name\":\"हिन्दी\"}],\"status\":\"Released\",\"tagline\":\"Come Fall In love, All Over Again..\",\"title\":\"Dilwale Dulhania Le Jayenge\",\"video\":false,\"vote_average\":8.7,\"vote_count\":2887}"
}