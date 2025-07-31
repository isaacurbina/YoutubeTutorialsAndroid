package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.Comment
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.Post
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.Role
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.User
import com.iucoding.youtubetutorialsandroid.ui.theme.YoutubeTutorialsAndroidTheme
import java.util.Date
import kotlin.random.Random

@Composable
fun PostItem(
	post: Post,
	onToggleClick: () -> Unit,
	modifier: Modifier = Modifier
) {
	LazyColumn(
		modifier = modifier,
		verticalArrangement = Arrangement.spacedBy(8.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		item {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.background(
						color = Color.White,
						shape = RoundedCornerShape(12.dp)
					)
					.border(
						width = 2.dp,
						color = Color.Gray,
						shape = RoundedCornerShape(12.dp)
					)
					.padding(16.dp),
				horizontalArrangement = Arrangement.spacedBy(16.dp)
			) {
				PostItem(post = post, modifier = Modifier.weight(0.8f))
				LikeIcon(
					modifier = modifier
						.weight(0.2f)
						.clickable { onToggleClick() },
					isLiked = post.isLiked,
				)
			}
		}
		items(post.comments) {
			Comment(
				modifier = Modifier
					.fillMaxWidth(0.8f)
					.background(
						color = Color.White,
						shape = RoundedCornerShape(12.dp)
					)
					.border(
						width = 1.dp,
						color = Color.Gray,
						shape = RoundedCornerShape(12.dp)
					)
					.padding(12.dp),
				comment = it
			)
		}
	}
}

@Composable
private fun PostItem(
	post: Post,
	modifier: Modifier = Modifier
){
	Column(modifier = modifier) {
		Text(
			modifier = Modifier.fillMaxWidth(),
			text = post.content,
			fontSize = 18.sp,
			fontWeight = FontWeight.Light
		)
		Text(
			modifier = Modifier.fillMaxWidth(),
			text = post.author.username,
			fontSize = 12.sp,
			fontWeight = FontWeight.SemiBold,
			textAlign = TextAlign.End
		)
		Text(
			modifier = Modifier.fillMaxWidth(),
			text = post.date.toString(),
			fontSize = 12.sp,
			fontWeight = FontWeight.Light,
			fontStyle = FontStyle.Italic,
			textAlign = TextAlign.End
		)
	}
}

@Composable
private fun LikeIcon(
	isLiked: Boolean,
	modifier : Modifier = Modifier
) {
	if (isLiked) {
		Icon(
			modifier = modifier,
			imageVector = Icons.Filled.ThumbUp,
			contentDescription = "Liked",
			tint = Color.Blue
		)
	} else {
		Icon(
			modifier = modifier,
			imageVector = Icons.Outlined.ThumbUp,
			contentDescription = "Not Liked",
			tint = Color.Gray
		)
	}
}

@Composable
private fun Comment(
	comment: Comment,
	modifier: Modifier = Modifier
) {
	Column(modifier = modifier) {
		Text(
			modifier = Modifier.fillMaxWidth(),
			text = comment.content,
			fontSize = 12.sp,
			fontWeight = FontWeight.Light
		)
		Text(
			modifier = Modifier.fillMaxWidth(),
			text = comment.author.username,
			fontSize = 10.sp,
			fontWeight = FontWeight.SemiBold,
			textAlign = TextAlign.End
		)
		Text(
			modifier = Modifier.fillMaxWidth(),
			text = comment.date.toString(),
			fontSize = 10.sp,
			fontWeight = FontWeight.Light,
			fontStyle = FontStyle.Italic,
			textAlign = TextAlign.End
		)
	}
}

@Preview
@Composable
private fun PostPreview() {
	YoutubeTutorialsAndroidTheme {
		PostItem(
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.LightGray)
				.padding(16.dp),
			post = Post(
				id = Random.nextLong().toString(),
				author = User(
					id = Random.nextLong().toString(),
					username = "John Doe",
					email = "john.doe@test.com",
					role = Role.ADMIN
				),
				content = "This is a test post for MVVM screen.",
				comments = listOf(
					Comment(
						id = Random.nextLong().toString(),
						author = User(
							id = Random.nextLong().toString(),
							username = "Jane Doe",
							email = "jane.doe@test.com",
							role = Role.USER
						),
						content = "This is the first comment.",
						date = Date()
					)
				),
				isLiked = Random.nextBoolean(),
				date = Date()
			)
		)
	}
}
