package ir.rezamahmoudi.divar.cityselection.domain.usecase

import com.google.common.truth.Truth.assertThat
import ir.rezamahmoudi.divar.cityselection.domain.repository.CitySelectionRepository
import ir.rezamahmoudi.divar.cityselection.util.fakedata.CITY_DTO_TEST_OBJECT
import ir.rezamahmoudi.divar.cityselection.util.fakedata.FIND_CURRENT_CITY_PARAMS_TEST_OBJECT
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class FindCurrentCityUseCaseTest {

    @Mock
    private lateinit var mockCitySelectionRepository: CitySelectionRepository

    private lateinit var getFindCurrentCityUseCase: FindCurrentCityUseCase

    @Before
    fun setup() {
        getFindCurrentCityUseCase =
            FindCurrentCityUseCase(mockCitySelectionRepository)
    }

    @Test
    fun `when repository returns successful response, invoking the use case should return success result`() {
        runTest {
            val response = Result.success(CITY_DTO_TEST_OBJECT)
            `when`(mockCitySelectionRepository.findCurrentCity(FIND_CURRENT_CITY_PARAMS_TEST_OBJECT)).thenReturn(response)

            // Act
            val result = getFindCurrentCityUseCase(FIND_CURRENT_CITY_PARAMS_TEST_OBJECT.lat, FIND_CURRENT_CITY_PARAMS_TEST_OBJECT.long)

            // Assert
            assertTrue(response.isSuccess)
            assertThat(CITY_DTO_TEST_OBJECT.asDomain()).isEqualTo(result.getOrNull())
        }
    }
}
