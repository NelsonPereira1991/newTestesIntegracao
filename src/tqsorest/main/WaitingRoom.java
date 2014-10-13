package tqsorest.main;

import java.util.PriorityQueue;

public class WaitingRoom {
	
	// Class Members
	private PriorityQueue<Client> m_clients;
	
	public WaitingRoom() {
		m_clients = new PriorityQueue<Client>();
	}

	public PriorityQueue<Client> get_clients() {
		return m_clients;
	}

	public void set_clients(PriorityQueue<Client> m_clients) {
		this.m_clients = m_clients;
	}
	
	public boolean clientArrive(Client arrivedClient) {
		arrivedClient.set_isOnWaitingRoom(true);
		return m_clients.add(arrivedClient);
	}
	
	public Client serveClient() {
		Client clientToReturn = m_clients.poll();
		if (clientToReturn != null) {
			clientToReturn.set_isOnWaitingRoom(false);
		}
		return clientToReturn;
	}
	
	public int getClientsNumber() {
		return m_clients.size();
	}

}
