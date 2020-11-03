package me.hsgamer.hscore.web;

import org.jetbrains.annotations.NotNull;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Methods on web
 */
public class WebUtils {

  private WebUtils() {

  }

  /**
   * Get JSON from the URL
   *
   * @param address the URL
   *
   * @return the JSON object
   *
   * @throws IOException    If there is an error when opening the connection
   * @throws ParseException If it fails to parse the JSON object
   */
  @NotNull
  public static Object getJSONFromURL(@NotNull String address) throws IOException, ParseException {
    return new JSONParser().parse(new InputStreamReader(openConnection(address).getInputStream()));
  }

  /**
   * Open a connection to the URL
   *
   * @param address the address / URL
   *
   * @return the connection
   *
   * @throws IOException If the URL is invalid or can't be connected
   */
  @NotNull
  public static URLConnection openConnection(@NotNull String address) throws IOException {
    URLConnection openConnection = createConnection(address);
    openConnection.addRequestProperty("User-Agent",
      "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
    openConnection.connect();
    return openConnection;
  }

  /**
   * Create a new connection
   *
   * @param address the address / URL
   *
   * @return the connection
   *
   * @throws IOException If the URL is invalid or can't be connected
   */
  @NotNull
  public static URLConnection createConnection(@NotNull String address) throws IOException {
    return new URL(address).openConnection();
  }
}
