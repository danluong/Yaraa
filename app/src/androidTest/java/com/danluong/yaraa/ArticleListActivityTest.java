package com.danluong.yaraa;

import android.app.ListActivity;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.core.deps.guava.io.ByteStreams;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;
import java.net.URL;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by dluong on 8/13/2015.
 */
@RunWith(AndroidJUnit4.class)
public class ArticleListActivityTest {

    @Rule
    public ActivityTestRule<ListActivity> mActivityRule = new ActivityTestRule<>(ListActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws Exception {
        // Read in data for MockWebServer
        String file = "test_data_positive.json";
        InputStream inputStream = getInstrumentation().getContext().getResources().getAssets().open(file);
        String inputString = new String(ByteStreams.toByteArray(inputStream));

        Log.d(ArticleListActivityTest.class.toString(), inputString);

        // Create a MockWebServer. These are lean enough that you can create a new
        // instance for every unit test.
        MockWebServer server = new MockWebServer();
        MockResponse response = new MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Cache-Control", "no-cache")
                .setBody(inputString);
        // Schedule some responses.
        server.enqueue(response);

        // Start the server.
        server.play();

        // Ask the server for its URL. You'll need this to make HTTP requests.
        URL baseUrl = server.getUrl("/top");

        // Exercise your application code, which should make those HTTP requests.
        // Responses are returned in the same order that they are enqueued.
//        Chat chat = new Chat(baseUrl);
//
//        chat.loadMore();
//        assertEquals("hello, world!", chat.messages());
//
//        chat.loadMore();
//        chat.loadMore();
//        assertEquals(""
//                + "hello, world!\n"
//                + "sup, bra?\n"
//                + "yo dog", chat.messages());
//
//        // Optional: confirm that your app made the HTTP requests you were expecting.
//        RecordedRequest request1 = server.takeRequest();
//        assertEquals("/v1/chat/messages/", request1.getPath());
//        assertNotNull(request1.getHeader("Authorization"));
//
//        RecordedRequest request2 = server.takeRequest();
//        assertEquals("/v1/chat/messages/2", request2.getPath());
//
//        RecordedRequest request3 = server.takeRequest();
//        assertEquals("/v1/chat/messages/3", request3.getPath());

        // Shut down the server. Instances cannot be reused.
        server.shutdown();
    }

    private static String readFileAsString(final String filename) throws Exception
    {
        InputStream inputStream = InstrumentationRegistry.getContext().getResources().getAssets().open(filename);
        String string = new String(ByteStreams.toByteArray(inputStream));
        Log.d(ArticleListActivityTest.class.toString(), string);

//        try
//        {
//            final URL resourceURL = ClassLoader.getSystemResource(filename);
//            if (resourceURL == null)
//            {
//                return null;
//            }
//
//            final String result = new String(Files.readAllBytes(Paths.get(resourceURL.toURI())),
//                    Charset.forName("UTF-8")); //$NON-NLS-1$
//            return result;
//        }
//        catch (final Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        return null;
        return string;
    }

}
