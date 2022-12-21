package com.zkybe.app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zkybe.app.dtos.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;

    @JsonIgnore
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private List<Message> receiverGroup;

    public void setUserPreferences(UserPreferences userPreferences) {
        this.userPreferences = userPreferences;
        this.userPreferences.setUser(this);
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
        this.userProfile.setUser(this);
    }

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserPreferences userPreferences;

    @JsonIgnore
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private List<FriendRequest> friendRequest;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY)
    private Set<FriendRequest> friendRequestSet;

    @OneToMany(mappedBy = "blockedUser", fetch = FetchType.LAZY)
    private List<BlockedUser> blockedUsers;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<BlockedUser> usersBlocked;

    @OneToMany(mappedBy = "reportedUser", fetch = FetchType.LAZY)
    private List<ReportedUser> reportedUsers;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ReportedUser> usersReported;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<UserGroup> groups = new ArrayList<>();
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            })
//    @JsonManagedReference
//    @JoinTable(name = "friendlists",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "friend_id")})
//    private List<User> friendlist;
//
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            },
//            mappedBy = "friendlist")
//    @JsonBackReference
//    @JsonIgnore
//    private List<User> friends;
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<FriendList> friendlist;

    @JsonIgnore
    @OneToMany(mappedBy = "friend", fetch = FetchType.LAZY)
    private List<FriendList> friendLists;
    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public User(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
    }

    public User(UserDTO user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
    }

    public User(Integer id, String nickname, String password) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }

//    public List<User> addToFriendlist(User friend) {
//        this.friendlist.add(friend);
//        return friendlist;
//    }
}
