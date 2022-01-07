package com.example.osiv.service;

import com.example.osiv.model.BasicUser;
import com.example.osiv.repository.BasicUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:10 PM
 */
@Service
public class SimpleUserService implements UserService{

    private final BasicUserRepository userRepository;
    public SimpleUserService(BasicUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    //در اینجا چیزی است که ما انتظار داریم زمانی رخ دهد که کد ما متد findOne را فراخوانی کند:
    //
    //در ابتدا ، پروکسی بهار تماس را رهگیری می کند و تراکنش فعلی را دریافت می کند یا در صورت عدم وجود یک تراکنش ایجاد می کند.
    //سپس ، فراخوانی متد را به پیاده سازی ما واگذار می کند.
    //سرانجام ، پروکسی معامله را انجام می دهد و در نتیجه session اصلی را می بندد. به هر حال ، ما فقط به آن Session در لایه سرویس خود نیاز داریم.
    //در پیاده سازی متد findOne ، مجموعه مجوزها را initialize نکردیم. بنابراین ، ما نباید بتوانیم از مجوزها پس از بازگشت متد استفاده کنیم. اگر این ویژگی را تکرار کنیم ، باید یک LazyInitializationException دریافت کنیم.
    public Optional<BasicUser> findOne(String userName) {
        return userRepository.findDetailedByUsername(userName);
    }
    //اگر OSIV فعال نبود ، ما مجبور بودیم تمام ارتباطات lazy associations لازم را در زمینه معامله به صورت دستی راه اندازی کنیم. ابتدایی ترین (و معمولاً اشتباه) استفاده از روش Hibernate.initialize () است:
//    @Override
//    @Transactional(readOnly = true)
//    public Optional<User> findOne(String username) {
//        Optional<User> user = userRepository.findByUsername(username);
//        user.ifPresent(u -> Hibernate.initialize(u.getPermissions()));
//
//        return user;
//    }



    //در حال حاضر ، تأثیر OSIV بر بهره وری توسعه دهندگان آشکار است. با این حال ، این همیشه در مورد بهره وری توسعه دهندگان نیست.
    //
}
