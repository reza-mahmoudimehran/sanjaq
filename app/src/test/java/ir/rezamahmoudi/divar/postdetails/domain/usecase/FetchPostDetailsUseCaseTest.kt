package ir.rezamahmoudi.divar.postdetails.domain.usecase

import com.google.common.truth.Truth.assertThat
import ir.rezamahmoudi.divar.core.util.network.connection.NetworkConnection
import ir.rezamahmoudi.divar.postdetails.data.mappers.mapToEntity
import ir.rezamahmoudi.divar.postdetails.domain.repository.PostDetailsRepository
import ir.rezamahmoudi.divar.postdetails.util.fakedata.FETCH_POST_DETAILS_PARAMS_TEST_OBJECT
import ir.rezamahmoudi.divar.postdetails.util.fakedata.POST_DETAILS_DTO_TEST_OBJECT
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class FetchPostDetailsUseCaseTest {

    @Mock
    private lateinit var mockPostDetailsRepository: PostDetailsRepository

    @Mock
    private lateinit var mockNetworkConnection: NetworkConnection

    private lateinit var getFetchPostDetailsUseCase: FetchPostDetailsUseCase

    @Before
    fun setup() {
        getFetchPostDetailsUseCase =
            FetchPostDetailsUseCase(mockPostDetailsRepository, mockNetworkConnection)
    }

    @Test
    fun `when the network is connected, invoking the use case should return the correct result and insert it into the database`() {
        runTest {
            val response = Result.success(POST_DETAILS_DTO_TEST_OBJECT)
            `when`(mockPostDetailsRepository.fetchPostDetails(FETCH_POST_DETAILS_PARAMS_TEST_OBJECT)).thenReturn(response)
            `when`(mockNetworkConnection.isConnected()).thenReturn(true)

            // Act
            val result = getFetchPostDetailsUseCase(FETCH_POST_DETAILS_PARAMS_TEST_OBJECT.postToken)

            // Assert
            assertTrue(response.isSuccess)
            assertThat(POST_DETAILS_DTO_TEST_OBJECT.asDomain()).isEqualTo(result.getOrNull())

            verify(mockPostDetailsRepository).fetchPostDetails(FETCH_POST_DETAILS_PARAMS_TEST_OBJECT)

            verify(mockPostDetailsRepository).insertPostDetails(POST_DETAILS_DTO_TEST_OBJECT.mapToEntity(FETCH_POST_DETAILS_PARAMS_TEST_OBJECT.postToken))

            verify(
                mockPostDetailsRepository,
                Mockito.times(0)
            ).getCachedPostDetails(Mockito.anyString())
        }
    }
}
