import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackegitim2.R
import com.example.jetpackegitim2.model.NoteModel
import com.example.jetpackegitim2.ui.notes.NotesViewModel

@Composable
fun NotesScreen(viewModel: NotesViewModel = hiltViewModel(), onClickDetail: (Int) -> Unit, onClickAdd: () -> Unit) {
    val noteUiState by viewModel.notes

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(noteUiState) {
                NoteItem(note = it, onClick = onClickDetail)
            }
        }

        Image(
            modifier = Modifier.padding(all = 16.dp).clickable {
                onClickAdd()
            }
                .size(60.dp)
                .align(Alignment.BottomEnd),
            painter = painterResource(id = R.drawable.ic_plus),
            contentDescription = null
        )
    }

}

@Composable
fun NoteItem(note: NoteModel, onClick: (Int) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onClick(note.id)
        }) {
        Text(modifier = Modifier.padding(16.dp), text = note.noteTitle)
    }
}