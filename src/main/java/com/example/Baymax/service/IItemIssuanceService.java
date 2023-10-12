package com.example.Baymax.service;

import java.util.List;

import com.example.Baymax.model.Loan;

public interface IItemIssuanceService {
	void saveItemIssued(Loan loan);

	List<Loan> getAllIssuedItems();

	List<Loan> getAllReturnedItem();

	List<Loan> getItemsWithFine();

	void deleteIssuedItemById(long id);

	Loan findItemIssuedById(long id);

	String validateLoanId(long loanId);

	Loan findItemIssued(long borrowerId, long itemId);
}
