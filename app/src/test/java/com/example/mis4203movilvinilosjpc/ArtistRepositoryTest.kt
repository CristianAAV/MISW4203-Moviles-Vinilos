import com.example.mis4203movilvinilosjpc.ActivityPrincipal.Artistas.Data.Modelo.Repositorio.ArtistRepository
import com.example.mis4203movilvinilosjpc.ActivityPrincipal.Artistas.Data.Modelo.DataItemArtista
import com.example.mis4203movilvinilosjpc.ActivityPrincipal.Artistas.Data.Modelo.DataPrizesClient
import com.example.mis4203movilvinilosjpc.ActivityPrincipal.Artistas.Data.Network.ArtistService
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ArtistRepositoryTest {

    @Mock
    private lateinit var mockArtistService: ArtistService

    private lateinit var artistRepository: ArtistRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        artistRepository = ArtistRepository(mockArtistService)
    }

    @Test
    fun `test getArtistFlow returns empty list`() = runBlocking {
        `when`(mockArtistService.getArtistsFlow()).thenReturn(flowOf(emptyList()))

        val result = artistRepository.getArtistFlow().firstOrNull()

        assert(result.isNullOrEmpty())
    }

    companion object {
        fun <T> flowOf(vararg values: T) = kotlinx.coroutines.flow.flow {
            values.forEach { emit(it) }
        }
    }
}