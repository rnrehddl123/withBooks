package com.mvc.withbooks.service;

import java.io.*;
import java.net.URL;
import java.util.*;

import javax.annotation.PostConstruct;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.FastIDSet;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.ReviewDTO;
import com.opencsv.CSVWriter;

@Service
public class RecommendService {
	@Autowired
	private ReviewMapper reviewMapper;
	@Autowired
	private MemberMapper memberMapper;
	
	static Map<Long, HashMap<Long, Float>> map;
	static List<Long> ulist;
	
	@PostConstruct
	public void recommend1() {
		
		DataModel dm;
		try {
			dm = new FileDataModel(new File("C:\\withbooksimage\\REVIEW.csv"));
			PearsonCorrelationSimilarity sim = new PearsonCorrelationSimilarity(dm);
			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);
			Map<Long, HashMap<Long, Float>> map = new HashMap<Long, HashMap<Long, Float>>();
			
			
			for(LongPrimitiveIterator items=dm.getItemIDs(); items.hasNext();) {
				long itemID = items.nextLong();
				List<RecommendedItem> recommendations = recommender.mostSimilarItems(itemID, 4);
				for(RecommendedItem recommendation : recommendations) {
					HashMap<Long, Float> map1 = new HashMap<Long, Float>();
					map1.put(recommendation.getItemID(), recommendation.getValue());
					map.put(itemID, map1);
				}
				this.map=map;
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(TasteException e) {
			e.printStackTrace();
		}
	}
	
	public Map<Long, HashMap<Long, Float>> getRecommend() {
		return map;
	}
	
	public List<Long> recommend2(int mnum) {
		DataModel dm;
		try {
			dm = new FileDataModel(new File("C:\\withbooksimage\\REVIEW.csv"));
			UserSimilarity sim = new PearsonCorrelationSimilarity(dm);
			UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, sim, dm);
			UserBasedRecommender recommender = new GenericUserBasedRecommender(dm, neighborhood, sim);
			List<Long> ulist = new ArrayList<Long>();
			for(LongPrimitiveIterator users=dm.getUserIDs(); users.hasNext();) {
				long userID = users.nextLong();
				List<RecommendedItem> recommendations = recommender.recommend(userID, 4);
				for(RecommendedItem recommendation : recommendations) {
					if(Long.valueOf(mnum)==userID) {
						ulist.add(recommendation.getItemID());
					}
				}
				this.ulist=ulist;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(TasteException e) {
			e.printStackTrace();
		}
		return ulist;
	}
	
	@PostConstruct
	public void writeCSV() {
        File csv = new File("C:\\withbooksimage\\REVIEW.csv");
        List<ReviewDTO> dataList = reviewMapper.listReview();
        BufferedWriter bw = null; // ?????? ????????? ??????
        try {
            bw = new BufferedWriter(new FileWriter(csv));
            // csv????????? ?????? ?????? ????????????

            for (int i = 0; i < dataList.size(); i++) {
                String[] data = null;
                data = new String[] {String.valueOf(dataList.get(i).getMemberDTO().getMnum()), 
                		String.valueOf(dataList.get(i).getNovelDTO().getNnum()),
                		String.valueOf(dataList.get(i).getScore())};
                // ????????? ????????? mnum, nnum, score ?????? ?????????
                String aData = "";
                aData = data[0] + "," + data[1] + "," + data[2];
                // ??? ?????? ?????? ??? ????????? ????????? ,??? ?????????
                bw.write(aData);
                // ????????? ???????????? ????????? ?????????
                bw.newLine(); // ??????
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.flush(); // ???????????? ??????????????? ?????? ??????
                    bw.close(); // ????????? BufferedWriter??? ?????? ??????
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
