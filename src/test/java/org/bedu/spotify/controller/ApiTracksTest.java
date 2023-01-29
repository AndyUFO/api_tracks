package org.bedu.spotify.controller;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({WelcomeControllerTest.class,SpotifyControllerTest.class,TrackControllerTest.class})
public class ApiTracksTest {
}
