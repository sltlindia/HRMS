package com.hrms.tds.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.kaizen.bean.KaizenManagerBean;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.tds.bean.TDSDocumentUploadBean;

public class TDSDeleteDAO {

	public boolean tdsDocumentDeleteByDocId(int tds_doc_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 TDSDocumentUploadBean tdsDocumentUploadBean = new TDSDocumentUploadBean(); 
			 tdsDocumentUploadBean.setTds_document_upload_id(tds_doc_id);
			 session.delete(tdsDocumentUploadBean);
			 tx.commit();
			 result = true;
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return result;
	}
}
