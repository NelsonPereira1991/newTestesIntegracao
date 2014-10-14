package tqsorest.tests;

import junit.framework.TestCase;

import org.junit.Test;

import tqsorest.main.Client;
import tqsorest.main.DiningRoom;
import tqsorest.main.WaitingRoom;

public class DiningRoomTest extends TestCase {
	// Test member data
	public WaitingRoom waitingRoom;
	public DiningRoom diningRoom;
	public Client client1;
	public Client client2;
	public Client client3;
	
	@Override
	public void setUp() {
		waitingRoom = new WaitingRoom();
		diningRoom = new DiningRoom(waitingRoom);
		client1 = new Client();
		client2 = new Client();
		client3 = new Client();
		
		waitingRoom.clientArrive(client1);
		waitingRoom.clientArrive(client2);
		waitingRoom.clientArrive(client3);
	}
	
	@Test
	public void testPickAClientFromWaitingRoom() {
		assertEquals(diningRoom.get_clientsInProgress().size(),0);
		diningRoom.pickAClientFromWaitingRoom();
		assertEquals("Test Pick A Client From Waiting Room Method", diningRoom.get_clientsInProgress().size(), 1);
	}
}

