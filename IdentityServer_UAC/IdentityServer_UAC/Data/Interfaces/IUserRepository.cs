namespace IdentityServer_UAC.Data.Interfaces
{
    public interface IUserRepository
    {
        Task<User?> GetUserAsync(string username, string password);

        Task<User?> GetUserAsync(int id);
    }
}
