/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import static java.lang.String.valueOf;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author horre
 */
public class userSignInNow {
    public static String userSignIn="";
    public static String userName="";
    public static int userAge;
    public static int currentBalanceUserSignIn=0;
    public static int dimondsUserSignIn=0;
    
    public static void increaseUserCurrrentBalance(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<user> user_list = null;
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        user_list = query.list();
        session.close();
        System.out.println("user list size: "+user_list.size());
        for(user u: user_list)
        {
            if(u.getEmail().equals(userSignIn)){
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session1.beginTransaction();
                currentBalanceUserSignIn = u.getCurrent_balance();
                tx.commit();
                
                session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx1 = session1.beginTransaction();
                currentBalanceUserSignIn += 5 ;
                u.setCurrent_balance(currentBalanceUserSignIn);
                session1.update(u);
                tx1.commit();
                session1.close();
               
            }
            
        }  
    }
    
    public static void decreaseUserCurrrentBalance(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<user> user_list = null;
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        user_list = query.list();
        session.close();
        System.out.println("user list size: "+user_list.size());
        for(user u: user_list)
        {
            if(u.getEmail().equals(userSignIn)){
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session1.beginTransaction();
                currentBalanceUserSignIn = u.getCurrent_balance();
                tx.commit();
                
                session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx1 = session1.beginTransaction();
                currentBalanceUserSignIn -= 15 ;
                u.setCurrent_balance(currentBalanceUserSignIn);
                session1.update(u);
                tx1.commit();
                session1.close();
            }
            
        }  
    }
    
    public static String getCurrrentBalance(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<user> user_list = null;
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        user_list = query.list();
        session.close();
        System.out.println("user list size: "+user_list.size());
        for(user u: user_list)
        {
            if(u.getEmail().equals(userSignIn)){
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session1.beginTransaction();
                currentBalanceUserSignIn = u.getCurrent_balance();
                tx.commit();
                session1.close();
            }
        } 
        String coins = valueOf(currentBalanceUserSignIn);
        return coins;
      }
    
    public static void increaseUserDimonds(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<user> user_list = null;
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        user_list = query.list();
        session.close();
        System.out.println("user list size: "+user_list.size());
        for(user u: user_list)
        {
            if(u.getEmail().equals(userSignIn)){
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session1.beginTransaction();
                dimondsUserSignIn = u.getDimonds();
                tx.commit();
                
                session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx1 = session1.beginTransaction();
                dimondsUserSignIn += 1 ;
                u.setDimonds(dimondsUserSignIn);
                session1.update(u);
                tx1.commit();
                session1.close();
            }
            
        }  
    }
    
    public static String getDimonds(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<user> user_list = null;
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        user_list = query.list();
        session.close();
        System.out.println("user list size: "+user_list.size());
        for(user u: user_list)
        {
            if(u.getEmail().equals(userSignIn)){
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session1.beginTransaction();
                dimondsUserSignIn = u.getDimonds();
                tx.commit();
                session1.close();
            }
        } 
        String dimonds = valueOf(dimondsUserSignIn);
        return dimonds;
      }
    
    public static int getCorrect_countForLevel_1(){
        int lvl_1_Correct_List = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();      
            List<user_pronounce_word> record_list = null;
            String queryStr = "from user_pronounce_word";
            Query query = session.createQuery(queryStr);
            record_list =  query.list();
            session.close();
            for(user_pronounce_word u: record_list){
                if (userSignInNow.userSignIn.equals(u.getEmail()) && u.getCorrect_count()==1 && u.getLevel_no()==1 ){
                    lvl_1_Correct_List = lvl_1_Correct_List + u.getCorrect_count();
                }
            } 
        return lvl_1_Correct_List;
    }
    
    public static int getCorrect_countForLevel_2(){
        int lvl_2_Correct_List = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();      
            List<user_pronounce_word> record_list = null;
            String queryStr = "from user_pronounce_word";
            Query query = session.createQuery(queryStr);
            record_list =  query.list();
            session.close();
            for(user_pronounce_word u: record_list){
                if (userSignInNow.userSignIn.equals(u.getEmail()) && u.getCorrect_count()==1 && u.getLevel_no()==2 ){
                    lvl_2_Correct_List = lvl_2_Correct_List + u.getCorrect_count();
                }
            } 
        return lvl_2_Correct_List;
    }
    
    public static int getCorrect_countForLevel_3(){
        int lvl_3_Correct_List = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();      
            List<user_pronounce_word> record_list = null;
            String queryStr = "from user_pronounce_word";
            Query query = session.createQuery(queryStr);
            record_list =  query.list();
            session.close();
            for(user_pronounce_word u: record_list){
                if (userSignInNow.userSignIn.equals(u.getEmail()) && u.getCorrect_count()==1 && u.getLevel_no()==3 ){
                    lvl_3_Correct_List = lvl_3_Correct_List + u.getCorrect_count();
                }
            } 
        return lvl_3_Correct_List;
    }

}
