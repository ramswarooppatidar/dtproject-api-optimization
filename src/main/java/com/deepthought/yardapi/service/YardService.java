package com.deepthought.yardapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.loading.PrivateClassLoader;

import org.springframework.stereotype.Service;

import com.deepthought.yardapi.enumerator.ConatinerSize;
import com.deepthought.yardapi.model.Container;
import com.deepthought.yardapi.model.Slot;
import com.deepthought.yardapi.model.YardRequest;

@Service
public class YardService {

	private static final int INVALID = 10_000;
	public Map<String, Object> findBestSpot(YardRequest yardRequest){
		Container c = yardRequest.getContainer();
		List<Slot> slots = yardRequest.getSlot();
		Map<String, Object> resultMap = new HashMap<>();
		
		Slot bestSlot = null;
        int minScore = Integer.MAX_VALUE;

		for(Slot slot: slots) {
			int score = calculateScore(c, slot);
//			minScore = Math.min(score, minScore);
			if(score < minScore) {
				score = minScore;
				bestSlot = slot;
			}
		}
		resultMap.put("conatiner", c.getId());
		resultMap.put("x", bestSlot.getX());
		resultMap.put("y", bestSlot.getY());
		return resultMap;
	}
	private int calculateScore(Container c, Slot slot) {
		//Manhattan Distance
		int distance = Math.abs(c.getX() - slot.getX()) + Math.abs(c.getY() - slot.getY());
		int sizePenalty = (ConatinerSize.BIG.equals(c.getSize()) && ConatinerSize.SMALL.equals(slot.getSizeCap())) ? INVALID : 0;
		int coldPenalty = c.isNeedsCold() && !slot.isHasColdUnit() ? INVALID : 0;
        int occupiedPenalty = slot.isOccupied() ? INVALID : 0;

        return distance + sizePenalty + coldPenalty + occupiedPenalty;
 
	}
}
