package tqsorest.tests.unit;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import tqsorest.main.Client;
import tqsorest.main.DiningRoom;
import tqsorest.main.WaitingRoom;

public class DiningRoomTest {
	// Test member data
	public WaitingRoom waitingRoom;
	public DiningRoom diningRoom;
	public Client client1;
	public Client client2;
	public Client client3;
	
	@Before
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
		assertEquals(0, diningRoom.get_clientsInProgress().size());
		diningRoom.pickAClientFromWaitingRoom();
		assertEquals("Test Pick A Client From Waiting Room Method", 1, diningRoom.get_clientsInProgress().size());
	}
}

