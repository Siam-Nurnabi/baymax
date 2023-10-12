package com.example.Baymax.service;

import java.util.List;

import com.example.Baymax.model.Borrower;

public interface IBorrowerService {
	Borrower getBorrowerById(long id);

	List<Borrower> getAllBorrowers();

	long getBorrowerIdByLoanId(long loanId);

	String validateBorrowerId(long borrowerId);

	void updateBorrower(Borrower borrower);
}
