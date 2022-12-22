using Microsoft.EntityFrameworkCore;

namespace IdentityServer_UAC.Data
{
    public class ZkybeDbContext : DbContext
    {
        public DbSet<User> Users { get; set; }

        public ZkybeDbContext(DbContextOptions<ZkybeDbContext> options) : base(options)
        {

        }

        // protected override void OnModelCreating(ModelBuilder modelBuilder)
        // {
        //     modelBuilder.Entity<User>()
        //         .Property(u => u.Id).HasConversion<Int32>();
        // 
        //     base.OnModelCreating(modelBuilder);
        // }
    }
}
