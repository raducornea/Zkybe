using IdentityServer_UAC.Data;
using IdentityServer4.Extensions;
using IdentityServer4.Models;
using IdentityServer4.Services;
using Microsoft.EntityFrameworkCore;
using System.Security.Claims;

namespace IdentityServer_UAC.Configurations
{
    public class ProfileService : IProfileService
    {
        private readonly ZkybeDbContext _dbContext;

        public ProfileService(ZkybeDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public async Task GetProfileDataAsync(ProfileDataRequestContext context)
        {
            var sub = context.Subject.GetSubjectId();
            var user = await _dbContext.Users.FirstOrDefaultAsync(x => x.Id == int.Parse(sub));
            if (user == null)
                return;

            var claims = new List<Claim>
            {
                new Claim("username", user.Nickname)
            };

            context.IssuedClaims.AddRange(claims);
        }

        public async Task IsActiveAsync(IsActiveContext context)
        {
            var sub = context.Subject.GetSubjectId();
            var user = await _dbContext.Users.FirstOrDefaultAsync(x => x.Id == int.Parse(sub));
            context.IsActive = user != null;
        }
    }
}
