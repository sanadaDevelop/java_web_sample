package jp.co.sample.point;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import jp.co.sample.dao.PointDao;
import jp.co.sample.dao.PointHistoryDao;
import jp.co.sample.model.Point;
import jp.co.sample.model.PointHistory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/point")
public class PointController {

	@RequestMapping
	public String index(@ModelAttribute @Valid HomeForm form,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "home";
		}
		
		int pointValue = Integer.valueOf(form.getPoint());
	    int userId = Integer.valueOf(form.getUsers());
	    
	    PointDao pointDao = new PointDao();
	    List<Point> points = pointDao.allAtId(userId);
	    Point point = new Point();
	    point.setUser_id(userId);
	    point.setPoint(pointValue);
	    if(points.size() > 0){
	        pointDao.update(point);
	    }else{
	        pointDao.insert(point);
	    }
	    
	    PointHistory pointHistory = new PointHistory();
	    pointHistory.setUser_id(userId);
	    pointHistory.setPoint(pointValue);
	    pointHistory.setCreated_at(new Date());
	    new PointHistoryDao().insert(pointHistory);
	    
		model.addAttribute("point", form.getPoint());
		return "point";
	}
}
