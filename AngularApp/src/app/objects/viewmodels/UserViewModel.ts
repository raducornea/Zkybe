export class UserViewModel {
    private nickname: string;
    private password: string;

    constructor(username: string, password: string) {
        this.nickname = username;
        this.password = password;
    }
}