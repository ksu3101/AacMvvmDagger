package domain.restingplaces.dto

/**
 * @author kangsungwoo
 * @since 6/18/2020
 */
data class RestingPlacePage(
    val hasNextPage: Boolean,
    val places: List<RestingPlace>
)

data class RestingPlace(
    val id: Long,
    val name: String,
    val thumbnail: String,
    val price: Long,
    val rate: Double,
    val detail: RestingPlaceDetail
)

data class RestingPlaceDetail(
    val image: String,
    val description: String,
    val location: String,
    val phone: String,
    val email: String
)

val restingPlacesMock: List<RestingPlace> = listOf(
    RestingPlace(
        100,
        "가나다라 마바사 아자차카 타파하",
        "",
        52000,
        4.20,
        RestingPlaceDetail(
            "",
            "abcd efg hijk lmn opqr stu vwxy z",
            "서울시 송파구 송파동 11-123",
            "010-1234-4321",
            "kanadara@gmail.com"
        )
    ),
    RestingPlace(
        101,
        "라라 가가 거 머머 퍼퍼 먐먀 먀",
        "",
        38000,
        3.60,
        RestingPlaceDetail(
            "",
            "doem sjdom lorem ipsum jja jjo bba",
            "서울시 강남구 뭐뭐길 55-1",
            "010-9901-5029",
            "lorem@gmail.com"
        )
    )
)