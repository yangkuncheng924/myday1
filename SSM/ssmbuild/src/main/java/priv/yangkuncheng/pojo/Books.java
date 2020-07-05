package priv.yangkuncheng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               //set get
@AllArgsConstructor //有参构造
@NoArgsConstructor  //无参构造
public class Books {
    private int bookid;
    private String bookname;
    private int bookcounts;
    private String detail;
}
