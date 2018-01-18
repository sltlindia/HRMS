package com.hrms.meetingmanagemnet.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.meetingmanagemnet.bean.MeetingAttachmentBean;
import com.hrms.meetingmanagemnet.bean.MeetingBookingDetailBean;
import com.hrms.meetingmanagemnet.bean.MeetingMOMBean;
import com.hrms.meetingmanagemnet.bean.MeetingRoomDetailBean;
import com.hrms.meetingmanagemnet.controller.FacilityDetailServlet;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.selfservice.bean.ComplaintBean;


public class AllListMeetingDAO{

	public List<MeetingRoomDetailBean> getRoom(int noOfParticipant)
	{
        List<MeetingRoomDetailBean> listOfRoom = new ArrayList<MeetingRoomDetailBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            
            if(noOfParticipant <=6) {
            	listOfRoom = session.createQuery("FROM MeetingRoomDetailBean where capacity < 9 and active=1").list();  
        	}else if(noOfParticipant >6 && noOfParticipant<9) {
        		listOfRoom = session.createQuery("FROM MeetingRoomDetailBean where capacity > 6 and capacity < 15 and active=1").list(); 
        	}else if(noOfParticipant > 8 && noOfParticipant<15) {
        		listOfRoom = session.createQuery("FROM MeetingRoomDetailBean where capacity > 8 and active=1").list();
        	}else  {
        		listOfRoom = session.createQuery("FROM MeetingRoomDetailBean where capacity > 14 and active=1").list();
        	}
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfRoom;
        
	}
	
	
	
	
	public List<MeetingBookingDetailBean> getAllBookings(int facilityId,String date)
	{
        List<MeetingBookingDetailBean> listOfBooking = new ArrayList<MeetingBookingDetailBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            
            listOfBooking = session.createQuery("FROM MeetingBookingDetailBean where date = '"+date+"' and  meetingRoomDetailBean = '"+facilityId+"'").list(); 
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfBooking;
        
	}
	
	
	
	public List<MeetingBookingDetailBean> getAllTimeScheduleCheck(int facilityId,String date,String startTime, String endTime)
	{
        List<MeetingBookingDetailBean> listOfBooking = new ArrayList<MeetingBookingDetailBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            
            listOfBooking = session.createQuery("FROM MeetingBookingDetailBean where date = '"+date+"' and  meetingRoomDetailBean = '"+facilityId+"' and ((Time('"+startTime+"') between from_time and to_time) OR (Time('"+endTime+"') between from_time and to_time) and (from_time between Time('"+startTime+"') and Time('"+endTime+"')) OR (to_time between Time('"+startTime+"') and Time('"+endTime+"')))").list(); 
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfBooking;
        
	}
	
	
	public List<MeetingBookingDetailBean> getAllTimeScheduleCheckByID(int facilityId,String date,String startTime, String endTime,int book_id)
	{
        List<MeetingBookingDetailBean> listOfBooking = new ArrayList<MeetingBookingDetailBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            
            listOfBooking = session.createQuery("FROM MeetingBookingDetailBean where date = '"+date+"' and  meetingRoomDetailBean = '"+facilityId+"' and ((Time('"+startTime+"') between from_time and to_time) OR (Time('"+endTime+"') between from_time and to_time) and (from_time between Time('"+startTime+"') and Time('"+endTime+"')) OR (to_time between Time('"+startTime+"') and Time('"+endTime+"'))) and meeting_booking_detail_id != '"+book_id+"'").list(); 
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfBooking;
        
	}
	
	
	
	public List<MeetingBookingDetailBean> getMeetingsByempId(int empId)
	{
        List<MeetingBookingDetailBean> listOfBooking = new ArrayList<MeetingBookingDetailBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            
            listOfBooking = session.createQuery("FROM MeetingBookingDetailBean where employeeBean = '"+empId+"' order by meeting_booking_detail_id DESC").list(); 
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfBooking;
        
	}
	
	
	
	public List<MeetingBookingDetailBean> getMeetingsByempIdGroupByFacility(int empId,String date)
	{
        List<MeetingBookingDetailBean> listOfBooking = new ArrayList<MeetingBookingDetailBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            
            listOfBooking = session.createQuery("FROM MeetingBookingDetailBean where employeeBean = '"+empId+"' and date='"+date+"' ").list(); 
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfBooking;
        
	}
	
	
	
	public List<MeetingBookingDetailBean> getMeetingsByempIdGroupByFacilityForHR(String date)
	{
        List<MeetingBookingDetailBean> listOfBooking = new ArrayList<MeetingBookingDetailBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            
            listOfBooking = session.createQuery("FROM MeetingBookingDetailBean where date='"+date+"' group by meetingRoomDetailBean").list(); 
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfBooking;
        
	}
	
	
	
	public List<MeetingBookingDetailBean> getMeetingsByFacilityId(int facilityId,String date)
	{
        List<MeetingBookingDetailBean> listOfBooking = new ArrayList<MeetingBookingDetailBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            
            listOfBooking = session.createQuery("FROM MeetingBookingDetailBean where date='"+date+"' and meetingRoomDetailBean='"+facilityId+"' ").list(); 
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfBooking;
        
	}
	
	
	
	
	public MeetingBookingDetailBean getBookinDetail(int bookingId)
	{
        Session session = HibernateUtil.openSession();
        Transaction tx = null;  
        MeetingBookingDetailBean bookingDetailBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query= session.createQuery("FROM MeetingBookingDetailBean WHERE  meeting_booking_detail_id='"+bookingId+"'");
            bookingDetailBean = (MeetingBookingDetailBean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bookingDetailBean;
        
	}
	
	
	public MeetingRoomDetailBean getRoomDetail(int roomId)
	{
        Session session = HibernateUtil.openSession();
        Transaction tx = null;  
        MeetingRoomDetailBean meetingRoomDetailBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query= session.createQuery("FROM MeetingRoomDetailBean WHERE  meeting_room_detail_id='"+roomId+"'");
            meetingRoomDetailBean = (MeetingRoomDetailBean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return meetingRoomDetailBean;
        
	}
	
	
	public List<MeetingBookingDetailBean> getListOfMeetingBySerchEngine(String fromDate, String toDate, String department,int count) {
		String v1 = null;
		String v2 = null;
		String v3 = null;

		String c1 = null;
		String c2 = null;
		String c3 = null;

		if (!fromDate.equalsIgnoreCase("")) {
			c1 = "date";
			v1 = fromDate;
		}

		if (!toDate.equalsIgnoreCase("")) {
			if (c1 == null) {
				c1 = "date";
				v1 = toDate;
			} else {
				c2 = "date";
				v2 = toDate;
			}
		}

		if (!department.equalsIgnoreCase("0")) {
			if (c1 == null) {
				c1 = "departmentBean";
				v1 = department;
			} else if (c2 == null) {
				c2 = "departmentBean";
				v2 = department;
			} else {
				c3 = "departmentBean";
				v3 = department;
			}
		}

		

		List<MeetingBookingDetailBean> listOfMeeting = new ArrayList<MeetingBookingDetailBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			if (c1.equals("date")) {

				if (count == 2) {
					listOfMeeting = session.createQuery("FROM MeetingBookingDetailBean where " + c1 + " between '" + v1
							+ "' and  '" + v2 + "'").list();
				} else if (count == 3) {
					listOfMeeting = session.createQuery("FROM MeetingBookingDetailBean where (" + c1 + " between '" + v1
							+ "' and '" + v2 + "') and " + c3 + " = '" + v3 + "'").list();
				}

			} else {
				if (count == 1) {
					listOfMeeting = session
							.createQuery("FROM MeetingBookingDetailBean where " + c1 + " = '" + v1 + "'")
							.list();
				}
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfMeeting;

	}
	
	
	
	public MeetingMOMBean getMeetingMOM(int bookID)
	{
        Session session = HibernateUtil.openSession();
        Transaction tx = null;  
        MeetingMOMBean meetingMOMBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query= session.createQuery("FROM MeetingMOMBean WHERE  meetingBookingDetailBean='"+bookID+"'");
            meetingMOMBean = (MeetingMOMBean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return meetingMOMBean;
        
	}
	
	
	public List<MeetingAttachmentBean> getAttachmentById(int bookId)
	{
        List<MeetingAttachmentBean> listOfAttachment = new ArrayList<MeetingAttachmentBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            
            listOfAttachment = session.createQuery("FROM MeetingAttachmentBean where meetingBookingDetailBean='"+bookId+"'").list(); 
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfAttachment;
        
	}
	
	
}
