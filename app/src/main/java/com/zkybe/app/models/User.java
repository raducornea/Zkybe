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
    @OneToMany(mappedBy = "sender")
    private List<Message> receiverGroup;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserPreferences userPreferences;

//    @JsonIgnore
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private ReportedUser reportedUser;

    @JsonIgnore
    @OneToOne(mappedBy = "sender")
    //@PrimaryKeyJoinColumn
    private FriendRequest friendRequest;

//    @JsonIgnore
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private BlockedUser blockedUser;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "receiver")
    private Set<FriendRequest> friendRequestSet;

//    @OneToMany(mappedBy = "blockedUser")
//    private Set<BlockedUser> blockedUsers;

    @OneToMany(mappedBy = "blockedUser")
   // @JoinColumn(name = "blocked_user_id", nullable = false)
    private List<BlockedUser> blockedUsers;

    @OneToMany(mappedBy = "user")
    private List<BlockedUser> usersBlocked;

    @OneToMany(mappedBy = "reportedUser")
    // @JoinColumn(name = "blocked_user_id", nullable = false)
    private List<ReportedUser> reportedUsers;

    @OneToMany(mappedBy = "user")
    private List<ReportedUser> usersReported;

//    @OneToMany(mappedBy = "reportedUser")
//    private Set<ReportedUser> reportedUsers;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserGroup> groups = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JsonManagedReference
    @JoinTable(name = "friendlists",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "friend_id")})
    private List<User> friendlist;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "friendlist")
    @JsonBackReference
    @JsonIgnore
    private List<User> friends;

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
    public List<User> addToFriendlist(User friend)
    {
        this.friendlist.add(friend);
        return friendlist;
    }
}
