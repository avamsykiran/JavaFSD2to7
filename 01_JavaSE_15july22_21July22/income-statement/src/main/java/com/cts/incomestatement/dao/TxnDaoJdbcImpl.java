package com.cts.incomestatement.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.incomestatement.exception.OperationFailedException;
import com.cts.incomestatement.model.Txn;
import com.cts.incomestatement.model.TxnType;

public class TxnDaoJdbcImpl implements TxnDao {
	
	public static final String INS_QRY="INSERT INTO txns(desp,amount,txndate,type) VALUES(?,?,?,?)";
	public static final String GET_LAST_INSERTED_QRY="SELECT max(txnId) FROM txns";
	public static final String GET_ALL_QRY="SELECT txnId,desp,amount,txndate,type FROM txns";
	public static final String GET_BY_ID_QRY="SELECT txnId,desp,amount,txndate,type FROM txns WHERE txnId=?";
	public static final String DEL_QRY="DELETE FROM txns WHERE txnId=?";

	private ConnectionProvider conProvider;
	
	public TxnDaoJdbcImpl() throws OperationFailedException {
		try {
			this.conProvider=ConnectionProvider.getInstance();
		} catch (IOException e) {
			//log the actual exp
			throw new OperationFailedException("Unable to to reach the database");
		}
	}
	
	@Override
	public Txn save(Txn txn) throws OperationFailedException {
		try(
				Connection con = conProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(INS_QRY);
				PreparedStatement pst2 = con.prepareStatement(GET_LAST_INSERTED_QRY);
				){
			
			pst.setString(1, txn.getDesp());
			pst.setDouble(2, txn.getAmount());
			pst.setDate(3, Date.valueOf(txn.getTxndate()));
			pst.setString(4, txn.getType().toString());
			
			pst.executeUpdate();
			
			ResultSet rs = pst2.executeQuery();
			if(rs.next()) {
				txn.setTxnId(rs.getInt(1));
			}
				
		}catch(SQLException exp) {
			exp.printStackTrace();
			throw new OperationFailedException("Unable to insert record");
		}
		return txn;
	}

	private Txn mapRow(ResultSet rs) throws SQLException {
		return new Txn(rs.getInt(1),rs.getString(2),rs.getDouble(3), rs.getDate(4).toLocalDate(), TxnType.valueOf(rs.getString(5)));
	}
	
	@Override
	public Txn getById(int txnId) throws OperationFailedException {
		Txn txn=null;
		try(
				Connection con = conProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_BY_ID_QRY);
				){
			pst.setInt(1, txnId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				txn = mapRow(rs);
			}
		}catch(SQLException exp) {
			exp.printStackTrace();
			throw new OperationFailedException("Unable to retrive record");
		}
		return txn;
	}

	@Override
	public List<Txn> getAll() throws OperationFailedException {
		List<Txn> txns=new ArrayList<Txn>();
		try(
				Connection con = conProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_QRY);
				){
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				txns.add( mapRow(rs));
			}
		}catch(SQLException exp) {
			exp.printStackTrace();
			throw new OperationFailedException("Unable to retrive records");
		}
		return txns;
	}

	@Override
	public void deleteById(int txnId) throws OperationFailedException {
		try(
				Connection con = conProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_QRY);
				){
			pst.setInt(1, txnId);
			pst.executeUpdate();
		}catch(SQLException exp) {
			exp.printStackTrace();
			throw new OperationFailedException("Unable to delete record");
		}
	}

}
