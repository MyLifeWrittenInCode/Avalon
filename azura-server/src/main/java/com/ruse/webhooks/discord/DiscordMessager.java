package com.ruse.webhooks.discord;

import java.awt.Color;
import java.io.File;
import java.net.URI;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import org.json.JSONObject;

import com.ruse.util.Misc;

import ca.momoperes.canarywebhooks.DiscordMessage;
import ca.momoperes.canarywebhooks.WebhookClient;
import ca.momoperes.canarywebhooks.WebhookClientBuilder;
import ca.momoperes.canarywebhooks.embed.DiscordEmbed;

public class DiscordMessager extends JSONObject {

	public static boolean active = true;

	private static String testhook = "https://discordapp.com/api/webhooks/749432787479560212/LdggLt4y-t6L1t20Ni7-508DfES0H-4IdyLsngxE3k_x9w92r4LgSZ-Wa5MzN-tyiSsn";
	private static String announcementhook = "https://discordapp.com/api/webhooks/264978407408795648/xEBWbkd51PIrM_Bv8xuYCWnTWonLAbVGcz_mNH62m0xfwSFnc62To2u_Q82vcp2G_oEo";
	private static String staffhook = "https://discordapp.com/api/webhooks/264978499528294420/XXkZF8s6k3f5MTgvJ8mAiok3W_ushBbSVaFfbo1UULqvmFtYfw0KNJFSpA85gh3Y7gws";
	private static String ingamehook = "https://discordapp.com/api/webhooks/264978586488930304/09Ondbuw6zvWtH9dltOZq30nLnRYp-y9xMPkPDa1xs4MyELl3kmftdiUFnyHzsx-ciGt";
	private static String debughook = "https://discordapp.com/api/webhooks/264978075513651221/4Qk7idRA2NbAmno_FOSmN8PH9D3_H4Un09eV3sg9Wx2TPOJjumuIFTi4dOprX_7cWmGa";
	private static String yellhook = "https://discordapp.com/api/webhooks/265081936165339137/NisWUHGJ8gR-tINeMHMBjQ7H-EJ8b6DznSx75f_NokM5DbIUuo7S874Ah9u3r4FRPYEx";
	private static String pmhook = "https://discordapp.com/api/webhooks/299735829218066432/TuAXNO5mgU93wRMEjnCsDiUZD3uco0AlrpPMYWt3yXt4px-X9FvbbxDgTERqFWUBA19l";
	private static String chathook = "https://discordapp.com/api/webhooks/299740022821879811/73pNXpfq3kMJSR6UNgMZqyWwPebyaYT4A_WAdwihXJNooKzPwdwgbAs8eDb3S2Jf5HAY";
	private static String clanhook = "https://discordapp.com/api/webhooks/299784483404644353/3M1Z_qzhen3C9FwDQXJeJ5NTzGTIYGkJBUo4jIucIJogJaLmXC8ukLhbloziNisZmiaN";
	private static String dragonkinghook = "https://discord.com/api/webhooks/963118213896495194/jLtj7bIWd5VEYjUfzsi3agCnoGjYA54RWXSaq0NY9dNeq0K0x6FBgHdYzUYTEDT8jt5b";
	private static String narakuhook = "https://discord.com/api/webhooks/963119856411103312/7g-uqX-FWnEqkDTDyI72587xYk68JAxooyFaF-Y7PLmyGkP9XD_hoTLx3LUVxkXo-27d";
	private static String nightmarebosshook = "https://discord.com/api/webhooks/963120028465655898/BwVf-RhLNbASaZKs56jrtBMuDDjhNVlad7sV3Ke5EaqWprKCxuysrXnP8dq3Dp23lnjw";
	private static String votebosshook = "https://discord.com/api/webhooks/963120303133835334/0y0GdPvBsQcMz8P889Z83R74luopoF9G-wPsJam4hEtuWu5FMB2hMJWS4JPcFvldm_7g";
	private static String afkbosshook = "https://discord.com/api/webhooks/963120700829339668/qsukZA_-iaHXfKT7RrAMS_uhUvaSa3vEojXGgHItWBq6gHs2I7jFXXHT9iStO3H82p4l";
	private static String gogetabosshook = "https://discord.com/api/webhooks/963121044669988904/2iGUZVXajUNFgxEQzRWGRuaIuU378c2JQqaUbAndZxk4ctrlepSM8MMXkxXNwZtvHT9R";
	private static String donationbosshook = "https://discord.com/api/webhooks/964275725811216436/76LexWSyaeqVPZQeOztYbZOb8ooloMwMGt5AZQsMvMAtLZfzQPhTqoyGGfyuz2mEVGdY";
	private static String ironbosshook = "https://discord.com/api/webhooks/969977018336804884/Bthzq3XSSpcYU0WAipZ7DAmsG_dE6UAB62prw5adRxZ41lgnviIxqZQVrWdE_t7R8ssa";

	public static void test(String msg) {
		try {

			String webhook = testhook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("NecroticRSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.YELLOW) // The color of the embed. You can leave this at null for no color
					.withDescription("This message was generated by the server.") // The description of the embed object
					.build(); // Build the embed element

			if (msg == null || msg == "") {
				msg = new String(
						"```hi this is a server test``` @everyone @crimson @crimson#2406 test \"quotes\" \nnewline :fire: :100: :ironman:");
			}

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
																								// message
					.withEmbed(embed) // Add our embed object
					.withUsername("Necrotic Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendDonationBossLog(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = donationbosshook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
					// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
					// description
					// of
					// the
					// embed
					// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
					// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Announcement Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendIronBossLog(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = ironbosshook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
					// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
					// description
					// of
					// the
					// embed
					// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
					// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Announcement Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendGogetaBossLog(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = gogetabosshook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
					// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
					// description
					// of
					// the
					// embed
					// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
					// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Announcement Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void sendAFKBossLog(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = afkbosshook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
					// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
					// description
					// of
					// the
					// embed
					// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
					// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Announcement Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendVoteBossLog(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = votebosshook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
					// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
					// description
					// of
					// the
					// embed
					// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
					// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Announcement Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void sendNightmareBossLog(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = nightmarebosshook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
					// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
					// description
					// of
					// the
					// embed
					// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
					// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Announcement Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendNarakuLog(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = narakuhook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
					// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
					// description
					// of
					// the
					// embed
					// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
					// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Announcement Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendDragonKingLog(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = dragonkinghook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
					// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
					// description
					// of
					// the
					// embed
					// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
					// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Announcement Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendAnnouncement(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = announcementhook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
																							// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
																																// description
																																// of
																																// the
																																// embed
																																// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
																								// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Announcement Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendStaffMessage(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = staffhook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.ORANGE) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
																																// description
																																// of
																																// the
																																// embed
																																// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
																								// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Staff Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendChatMessage(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = chathook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.YELLOW) // The color of the embed. You can leave this at null for no color
					// .withDescription("Remember, you can mute any specific channel by clicking the
					// bell in the top right of Discord.") // The description of the embed object
					.build(); // Build the embed element

			String msgToSend = Misc.stripIngameFormat(msg);

			DiscordMessage message = new DiscordMessage.Builder(msgToSend) // The content of the message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Chat Bot") // Override the username of the bot
					.build(); // Build the message

			if (msgToSend.equalsIgnoreCase(":information_source:!")) {
				sendDebugMessage("Bad message from sendChatMessage, \n" + msgToSend);
			} else {
				client.sendPayload(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendClanMessage(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = clanhook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					// .withDescription("Remember, you can mute any specific channel by clicking the
					// bell in the top right of Discord.") // The description of the embed object
					.build(); // Build the embed element

			String msgToSend = Misc.stripIngameFormat(msg);

			DiscordMessage message = new DiscordMessage.Builder(msgToSend) // The content of the message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Clan Bot") // Override the username of the bot
					.build(); // Build the message

			if (msgToSend.equalsIgnoreCase(":information_source:!")) {
				sendDebugMessage("Bad message from sendClanMessage, \n" + msgToSend);
			} else {
				client.sendPayload(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendPrivateMessage(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = pmhook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.MAGENTA) // The color of the embed. You can leave this at null for no color
					// .withDescription("Remember, you can mute any specific channel by clicking the
					// bell in the top right of Discord.") // The description of the embed object
					.build(); // Build the embed element

			String msgToSend = Misc.stripIngameFormat(msg);

			DiscordMessage message = new DiscordMessage.Builder(msgToSend) // The content of the message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Privacy Bot") // Override the username of the bot
					.build(); // Build the message

			if (msgToSend.equalsIgnoreCase(":information_source:!")) {
				sendDebugMessage("Bad message from sendPrivateMessage, \n" + msgToSend);
			} else {
				client.sendPayload(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendInGameMessage(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = ingamehook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.BLUE) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
																																// description
																																// of
																																// the
																																// embed
																																// object
					.build(); // Build the embed element

			String msgToSend = Misc.stripIngameFormat(msg);

			DiscordMessage message = new DiscordMessage.Builder(msgToSend) // The content of the message
					// .withEmbed(embed) // Add our embed object
					.withUsername("In-Game Bot") // Override the username of the bot
					.build(); // Build the message

			if (msgToSend.equalsIgnoreCase(":information_source:!")) {
				sendDebugMessage("Bad message from sendInGameMessage, \n" + msgToSend);
			} else {
				client.sendPayload(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendDebugMessage(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = debughook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
																							// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.MAGENTA) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
																																// description
																																// of
																																// the
																																// embed
																																// object
					.build(); // Build the embed element

			// DiscordMessage message = new DiscordMessage.Builder(msg)
			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
																								// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Debug Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendYellMessage(String msg) {
		try {

			if (Misc.checkForOwner() || !active) {
				return;
			}

			String webhook = yellhook;

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.WHITE) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
																																// description
																																// of
																																// the
																																// embed
																																// object
					.build(); // Build the embed element

			String msgToSend = Misc.stripIngameFormat(msg);

			DiscordMessage message = new DiscordMessage.Builder(msgToSend) // The content of the message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Yell Bot") // Override the username of the bot
					.build(); // Build the message

			if (msgToSend.equalsIgnoreCase(":information_source:!")) {
				sendDebugMessage("Bad message from sendYellMessage, \n" + msgToSend);
			} else {
				client.sendPayload(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * // System.out.println("test"); URL url = new URL(
	 * "https://discordapp.com/api/webhooks/264884075129470976/NvJNe980SYO3DKjOPxoJRx9ew6Y9T6jYxteG_HOZ9zPNewCUj2vskZZMsjtzBiiOn75J"
	 * ); HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	 * conn.setDoOutput(true); conn.setRequestMethod("POST");
	 * conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	 * conn.setRequestProperty("Accept", "application/json; charset=UTF-8");
	 *
	 * JSONObject discord = new JSONObject();
	 *
	 * //ARGS: username, content, avatar_url, tts discord.put("username", "test");
	 * discord.put("content",
	 * "@everyone hallo it is me a fRIENDD!@@#!@#!@#!@#!@#!@#!@#!@#!@#");
	 *
	 * //discord.put("avatar_url", "http://i.imgur.com/4Da0jRZ.png");
	 * //discord.put("tts", false);
	 *
	 * OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	 * discord.write(wr); wr.flush();
	 *
	 * StringBuilder sb = new StringBuilder(); int HttpResult =
	 * conn.getResponseCode(); if (HttpResult == HttpURLConnection.HTTP_OK) {
	 * // System.out.println("HTTP = OK"); BufferedReader br = new BufferedReader( new
	 * InputStreamReader(conn.getInputStream(), "utf-8")); String line = null; while
	 * ((line = br.readLine()) != null) { sb.append(line + "\n"); } br.close();
	 * // System.out.println("" + sb.toString()); } else {
	 * // System.out.println("HTTP = NOT OK");
	 * // System.out.println(conn.getResponseMessage()); }
	 */

}
