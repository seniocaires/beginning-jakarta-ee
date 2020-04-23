package book.jakarta8.calypsojpa.ejb;

import javax.ejb.SessionSynchronization;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

// Observing Transaction for Stateful EJB
// Only if you use container-managed transactions and only in the case of stateful session
// EJBs can you let your EJB implement the SessionSynchronization interface and then
// react on transaction boundaries, as follows:
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SomeEJB implements SessionSynchronization {

	@Override
	public void afterBegin() {
		System.err.println("A transaction has started");
	}

	@Override
	public void beforeCompletion() {
		System.err.println("A transaction is about to be finished");
	}

	@Override
	public void afterCompletion(boolean committed) {
		System.err.println("A transaction has finished");
	}
}
