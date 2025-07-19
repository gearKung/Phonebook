package contact;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PageList {
	private int currentPage;	//현재페이지
	private int totalCount;		//전체 글의 수	
	private int pagePerCount=10;//페이지당 글의 수
	private int totalPage;		//전체 페이지 
	
	private int startPage;		//네비게이트 시작번호
	private int endPage;		//네비게이트 끝 번호
	private boolean isPre;		//네비게이트 이전표시 여부 getPre(), setPre() -> 
	private boolean isNext;		//네비게이트 다음표시 여부
	
	List<ContactList> list;			//연락처 페이지 리스트 
}
