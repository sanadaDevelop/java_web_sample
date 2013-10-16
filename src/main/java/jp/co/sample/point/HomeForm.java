package jp.co.sample.point;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class HomeForm implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
    private Integer point;

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

}
