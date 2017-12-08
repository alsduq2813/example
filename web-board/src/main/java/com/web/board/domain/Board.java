package com.web.board.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="BOARD")
@SequenceGenerator(name="BOARD_SEQ_GENERATOR",
sequenceName="BOARD_SEQ",
initialValue=1,
allocationSize=1) 
public class Board {
	
	@Id
	@GeneratedValue
	@Column(length=10)
	private int board_no;
	
	@Size(max=25)
	@NotNull
	private String writer;
	
	@Size(max = 300)
	@NotNull
	private String title;
	
	@Size(max = 3000)
	private String detail;
	
    private Date reg; 
    
    @PrePersist
    protected void onReg() {
      reg = new Date();
    }

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getReg() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return reg;
	}

	public void setReg(Date reg) {
		this.reg = reg;
	}
	
	
	
	

}
