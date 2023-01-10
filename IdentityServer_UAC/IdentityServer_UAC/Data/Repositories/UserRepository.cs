using IdentityServer_UAC.Data.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace IdentityServer_UAC.Data.Repositories
{
    public class UserRepository : IUserRepository
    {
        private readonly ZkybeDbContext _dbContext;

        public UserRepository(ZkybeDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public async Task<User?> GetUserAsync(string username, string password)
        {
            return await _dbContext.Users
                .FirstOrDefaultAsync(u => u.Nickname == username && u.Password == password);
        }

        public async Task<User?> GetUserAsync(int id)
        {
            return await _dbContext.Users.FirstOrDefaultAsync(u => u.Id == id);
        }
    }
}
