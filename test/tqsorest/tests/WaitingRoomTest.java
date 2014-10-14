package tqsorest.tests;

import junit.framework.TestCase;

import org.junit.Test;

import tqsorest.main.Client;
import tqsorest.main.WaitingRoom;

public class WaitingRoomTest extends TestCase {
	// Test member data
	public WaitingRoom waitingRoom;
	public Client client1;
	public Client client2;
	public Client client3;
	
	@Override
	public void setUp() {
		waitingRoom = new WaitingRoom();
		client1 = new Client();
		client2 = new Client();
		client3 = new Client();
		
		waitingRoom.clientArrive(client1);
		waitingRoom.clientArrive(client2);
	}
	
	@Test
	public void testClientQueueSize() {
		assertEquals("Test Get Client Size Method", waitingRoom.getClientsNumber(),2);
	}
	
	@Test
	public void testClientArrive() {
		waitingRoom.clientArrive(client3);
		assertEquals("Test Client Arrive Method", waitingRoom.getClientsNumber(), 3);
	}
	
	@Test
	public void testServeClient() {
		assertEquals("Test Serve Client Method", waitingRoom.getClientsNumber(), 2);
	}
}
