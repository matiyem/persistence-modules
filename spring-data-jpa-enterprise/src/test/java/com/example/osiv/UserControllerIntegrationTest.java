package com.example.osiv;

import com.example.osiv.model.BasicUser;
import com.example.osiv.repository.BasicUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ContextConfiguration(classes = OsivApplication.class)
class UserControllerIntegrationTest {
//در اینجا ، ما مجوزها را در طول تبدیل نهاد به DTO تکرار می کنیم.
// از آنجا که ما انتظار داریم این تبدیل با LazyInitializationException شکست بخورد ،
//از آنجا که OSIV یک Session در ابتدای درخواست ایجاد می کند ، پروکسی تراکنش به جای ایجاد یک جلسه جدید ، از Session موجود موجود استفاده می کند.
//متأسفانه ، خستگی connection pool تنها مشکل عملکرد OSIV نیست.
//از آنجایی که Session برای کل چرخه عمر درخواست باز است ، برخی از ناوبری های دارایی ممکن است چند درخواست ناخواسته دیگر را خارج از زمینه معامله ایجاد کند. حتی ممکن است به مشکل انتخاب n+1 برسید ، و بدترین خبر این است که ممکن است تا زمان تولید متوجه این موضوع نشویم.
//Adding insult to injury, the Session executes all those extra queries in auto-commit mode. In auto-commit mode, each SQL statement is treated as a transaction and is automatically committed right after it is executed. This, in turn, puts a lot of pressure on the database.
//اینکه OSIV یک الگو است یا ضد الگو ، اهمیتی ندارد. مهمترین چیز در اینجا واقعیتی است که ما در آن زندگی می کنیم.
//اگر ما در حال توسعه یک سرویس ساده CRUD هستیم ، ممکن است استفاده از OSIV منطقی باشد ، زیرا ممکن است هرگز با آن مشکلات عملکردی مواجه نشویم.
//از سوی دیگر ، اگر متوجه شدیم که با سرویس های راه دور زیادی تماس می گیریم یا خارج از محدوده معاملاتی ما موارد زیادی در حال انجام است ، توصیه می شود OSIV را به طور کلی غیرفعال کنید.
//    در صورت شک ، بدون OSIV شروع کنید ، زیرا بعداً می توانیم به راحتی آن را فعال کنیم. از سوی دیگر ، غیرفعال کردن OSIV که قبلاً فعال شده است ممکن است دشوار باشد ، زیرا ممکن است نیاز به انجام بسیاری از استثنائات LazyInitializationExceptions داشته باشیم.
//نکته نهایی این است که هنگام استفاده یا نادیده گرفتن OSIV باید از مبادلات آگاه باشیم.
//    اگر OSIV را غیرفعال کنیم ، باید به نحوی از استثنائات بالقوه LazyInitializationEx هنگام برخورد با انجمن های تنبل جلوگیری کنیم. در میان چند رویکرد برای مقابله با انجمن هایlazy  ، ما قصد داریم در اینجا دو مورد از آنها را برشماریم.
    @Autowired
    private BasicUserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        BasicUser user = new BasicUser();
        user.setUsername("root");
        user.setPermissions(new HashSet<>(Arrays.asList("PERM_READ", "PERM_WRITE")));

        userRepository.save(user);
    }

    @Test
    void givenTheUserExists_WhenOsivIsEnabled_ThenLazyInitWorkEverywhere() throws Exception {
        mockMvc.perform(get("/users/root"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("root"))
                .andExpect(jsonPath("$.permissions", containsInAnyOrder("PERM_READ", "PERM_WRITE")));
    }

    @AfterEach
    void flushDb() {
        userRepository.deleteAll();
    }
}
