package com.my.test.ui.presentation.providers

import com.my.test.domain.model.Provider
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.my.test.common.StringUtils
import com.my.test.ui.theme.Grey
import com.my.test.ui.theme.Red

@Composable
fun ProviderCard(provider: Provider) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .semantics(mergeDescendants = true) {},
        shape = RectangleShape
    ) {
        val context = LocalContext.current

        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
        ) {
            // Icon, Name & Distance
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "",
                        tint = Grey
                    )
                    Text(
                        text = StringUtils.toTitleCase(provider.name)
                    )
                }
                Text(
                    text = "${provider.distance} km away",
                    fontSize = 14.sp,
                    textAlign = TextAlign.End
                )
            }

            // Address
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = StringUtils.toTitleCase(provider.address))
            }

            Row(Modifier.fillMaxWidth()) {
                Text(text = StringUtils.toTitleCase(provider.city) + ", " + provider.province?.uppercase() + " " + provider.postalCode?.uppercase())
            }

            // Phone Number
            Row(Modifier.fillMaxWidth()) {
                var providerPhone = provider.phone?.let { provider.phone.replace(" ", "-") }
                Text(
                    text = providerPhone ?: "",
                    color = Red,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + provider.phone))
                        context.startActivity(intent)
                    })
            }

            // Save Contact
            Row(Modifier.fillMaxWidth()) {
                TextButton(onClick = { /*TODO*/ }, contentPadding = PaddingValues(0.dp)) {
                    Text(color = Red, text = "Save Contact", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
