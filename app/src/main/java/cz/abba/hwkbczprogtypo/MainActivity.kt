package cz.abba.hwkbczprogtypo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.abba.hwkbczprogtypo.ui.theme.HwKbCZProgTypoTheme

class MainActivity: ComponentActivity() {
	private lateinit var title: String
	private lateinit var text: String
	@OptIn(ExperimentalMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		title = getText(R.string.app_name).toString()
		text = getText(R.string.app_welcome).toString()
		enableEdgeToEdge()
		setContent {
			HwKbCZProgTypoTheme {
				Scaffold(
					modifier = Modifier.fillMaxSize(),
					topBar = {
						TopAppBar(
							colors = topAppBarColors(
								containerColor = MaterialTheme.colorScheme.primaryContainer,
								titleContentColor = MaterialTheme.colorScheme.primary,
								),
							title = {
								Text(title)
							}
						)
					},
				) { innerPadding ->
					Greeting(
						name = text,
						modifier = Modifier.padding(innerPadding)
					)
				}
			}
		}
	}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = name,
		modifier = modifier.padding(all = 16.dp)
	)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	HwKbCZProgTypoTheme {
		Greeting(
			"Czech Programmer Typographic Layout for HW Keyboard",
			Modifier.padding(16.dp)
		)
	}
}