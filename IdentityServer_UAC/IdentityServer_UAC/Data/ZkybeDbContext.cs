using Microsoft.EntityFrameworkCore;

namespace IdentityServer_UAC.Data
{
    public class ZkybeDbContext : DbContext
    {
        public DbSet<User> Users { get; set; }

        public ZkybeDbContext(DbContextOptions<ZkybeDbContext> options) : base(options)
        {

        }
    }
}
